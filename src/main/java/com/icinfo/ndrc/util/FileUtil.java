package com.icinfo.ndrc.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * 创建文件夹
	 *
	 * @author zhuyong
	 * @param floderPath
	 */
	public static void mkDir(String floderPath) {
		File file = new File(floderPath);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
	}
	

	/**
	 * 文件拷贝
	 * 
	 * @author zhuyong
	 * @param sourcePath
	 * @param targetPath
	 */
	public static void fileCopy(String sourcePath, String targetPath) {
		try {
			FileCopyUtils.copy(new FileInputStream(sourcePath), new FileOutputStream(targetPath));
		} catch (Exception e) {
			logger.info("文件拷贝出错");
		}
	}

	/**
	 * 上传本地接口
	 * 
	 * @param files
	 * @param fileName
	 * @return
	 */
	public static String uploadToLoc(MultipartFile files, String fileName, String fileLocPath) {
		System.out.println("上传到本地开始");
		File targetFile = new File(fileLocPath, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			files.transferTo(targetFile);
			System.out.println("上传到本地结束");
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 从本地下载接口
	 * 
	 * @param fileName
	 * @return
	 */
	public static ResponseEntity<byte[]> downFromLoc(String fileName, HttpServletRequest request, String filePath) {
		byte[] buffer = null;
		HttpHeaders headers = new HttpHeaders();
		try {
			File file = new File(filePath + File.separator + fileName);
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
			// 处理响应
			int index = fileName.indexOf("-");
			fileName = fileName.substring(index + 1);
			if (request.getHeader("User-Agent").contains("MSIE")
					|| request.getHeader("User-Agent").contains("Trident")) {
				fileName = java.net.URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
			} else {
				// 非IE浏览器的处理
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			headers.setContentDispositionFormData("attachment", fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(buffer, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 读取Excel表头的内容
	 * @author fanzhen
	 * @date 20170615
	 * @param is
	 * @return
	 */
	 public static String readExcelTitle(InputStream is) {
		    POIFSFileSystem fs;
		    HSSFWorkbook wb = new HSSFWorkbook();
		    HSSFSheet sheet;
		    HSSFRow row;
	        try {
	            fs = new POIFSFileSystem(is);
	            wb = new HSSFWorkbook(fs);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        sheet = wb.getSheetAt(0);
	        row = sheet.getRow(0);
	        // 标题总列数
	        int colNum = row.getPhysicalNumberOfCells();
	        System.out.println("colNum:" + colNum);
	        String title = "";
	        for (int i = 0; i < colNum; i++) {
	            title = title + getStringCellValue(row.getCell((short) i))+",";
//	            title[i] = getCellFormatValue(row.getCell((short) i));
	        }
	        return title;
	    }
	 /**
	  * 读取String类型的值
	  * @author fanzhen
	  * @dete20170615
	  * @param cell
	  * @return
	  */
	 private static String getStringCellValue(HSSFCell cell) {
	        String strCell = "";
	        switch (cell.getCellType()) {
	        case HSSFCell.CELL_TYPE_STRING:
	            strCell = cell.getStringCellValue();
	            break;
	        case HSSFCell.CELL_TYPE_NUMERIC:
	            strCell = String.valueOf(cell.getNumericCellValue());
	            break;
	        case HSSFCell.CELL_TYPE_BOOLEAN:
	            strCell = String.valueOf(cell.getBooleanCellValue());
	            break;
	        case HSSFCell.CELL_TYPE_BLANK:
	            strCell = "";
	            break;
	        default:
	            strCell = "";
	            break;
	        }
	        if (strCell.equals("") || strCell == null) {
	            return "";
	        }
	        if (cell == null) {
	            return "";
	        }
	        return strCell;
	    }

	 /**
	  * 读取sheet
	  * @author fanzhen
	  * @date 20170615
	  * @param is
	  * @return
	 * @throws IOException 
	  */
	 public static String readSheet(InputStream is) throws IOException{
		 	POIFSFileSystem fs = new POIFSFileSystem(is);
			HSSFWorkbook workbook = new HSSFWorkbook(fs);
		    int num = workbook.getNumberOfSheets();
		    workbook.getSheetAt(num);
		 return "";
	 }
	 
	 /**
		 * 描述：有效的sheet数量统计
		 * @author fanzhen
		 * @date 20170615
		 * @param sheetNamesArr
		 * @param workbook
		 * @return
		 */
		private  static int validSheetCount(String[] sheetNamesArr, HSSFWorkbook workbook) {
			StringBuffer tempStr = new StringBuffer();
		    int count = 0;
			for (String sheetName : sheetNamesArr) {
				tempStr.append(sheetName+"-");
			}
			for(int i=0;i<workbook.getNumberOfSheets();i++){
				if(tempStr.toString().contains(workbook.getSheetAt(i).getSheetName()))
					count++;
			}
			return count;
		}
		
		//读取表格内容
		 public static String getCell(HSSFCell cell) {
				DecimalFormat df = new DecimalFormat("###.###");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if (cell == null)
					return "";
				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_NUMERIC:
					if(HSSFDateUtil.isCellDateFormatted(cell)){
						return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
					}
					return df.format(cell.getNumericCellValue());
				case HSSFCell.CELL_TYPE_STRING:
					return cell.getStringCellValue();
				case HSSFCell.CELL_TYPE_FORMULA:
					return cell.getCellFormula();
				case HSSFCell.CELL_TYPE_BLANK:
					return "";
				case HSSFCell.CELL_TYPE_BOOLEAN:
					return cell.getBooleanCellValue() + "";
				case HSSFCell.CELL_TYPE_ERROR:
					return cell.getErrorCellValue() + "";
				}
				return "";
			}
}
