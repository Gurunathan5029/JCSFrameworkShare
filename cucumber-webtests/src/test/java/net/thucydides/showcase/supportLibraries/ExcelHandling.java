package net.thucydides.showcase.supportLibraries;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.steps.ScenarioSteps;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.org.apache.xml.internal.utils.URI;
import com.sun.org.apache.xml.internal.utils.URI.MalformedURIException;

public class ExcelHandling implements ReportHandling {

	/**
	 * @param args
	 */

	static int i = 0;
	static Calendar cal = Calendar.getInstance();
	static Date date = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd-HH-mm-ss");
	static String systemdate = dateFormat.format(date);
	String Filepath = "C:\\Users\\gunasegx\\Desktop\\cucumber-webtests\\TestResultImages"
			+ "\\Report" + systemdate + ".xlsx";
	String ImagePath = "C:\\Users\\gunasegx\\Desktop\\cucumber-webtests\\TestResultImages\\";

	public void screenShot() {
		BufferedImage image;

		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit
					.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(ImagePath + i + ".png"));
		} catch (HeadlessException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void resultstatus(String x, String y, status z) {

		if (i == 0) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Test Result");
			Row row = sheet.createRow(i);
			String[] headers = { "Test Step", "Description", "Status" };
			for (int j = 0; j < 3; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(headers[j]);
			}
			Row row1 = sheet.createRow(++i);
			String[] headers1 = { x, y, z.toString() };
			for (int j = 0; j < 3; j++) {
				Cell cell = row1.createCell(j);
				if (headers1[j].equalsIgnoreCase("Pass")) {
					XSSFCellStyle style = workbook.createCellStyle();
					CreationHelper createHelper = workbook.getCreationHelper();
					CellStyle hlink_style = workbook.createCellStyle();
					Font hlink_font = workbook.createFont();
					hlink_font.setUnderline(Font.U_SINGLE);
					hlink_font.setColor(IndexedColors.GREEN.getIndex());
					/*
					 * File scrFile =
					 * ((TakesScreenshot)driver).getScreenshotAs(OutputType
					 * .FILE); try { String FullAddress=ImagePath+i+".PNG";
					 * System.out.println(FullAddress);
					 * FileUtils.copyFile(scrFile, new File(FullAddress));
					 * hlink_style.setFont(hlink_font);
					 * 
					 * Hyperlink hp =
					 * createHelper.createHyperlink(Hyperlink.LINK_FILE);
					 * hp.setAddress(FullAddress); cell.setHyperlink(hp);
					 */
					screenShot();
					hlink_style.setFont(hlink_font);
					String FullAddress = ImagePath + i + ".PNG";
					File f2 = new File(FullAddress);
					String windowsPath = f2.toURI().toString();

					Hyperlink hp = createHelper
							.createHyperlink(Hyperlink.LINK_FILE);
					hp.setAddress(windowsPath);
					cell.setHyperlink(hp);
					cell.setCellStyle(hlink_style);

					cell.setCellValue(headers1[j]);
				} else if (headers1[j].equalsIgnoreCase("Fail")) {
					XSSFCellStyle style = workbook.createCellStyle();
					CreationHelper createHelper = workbook.getCreationHelper();
					CellStyle hlink_style = workbook.createCellStyle();
					Font hlink_font = workbook.createFont();
					hlink_font.setUnderline(Font.U_SINGLE);
					hlink_font.setColor(IndexedColors.RED.getIndex());
					/*
					 * File scrFile =
					 * ((TakesScreenshot)driver).getScreenshotAs(OutputType
					 * .FILE); try { String FullAddress=ImagePath+i+".PNG";
					 * System.out.println(FullAddress);
					 * FileUtils.copyFile(scrFile, new File(FullAddress));
					 * hlink_style.setFont(hlink_font);
					 * 
					 * Hyperlink hp =
					 * createHelper.createHyperlink(Hyperlink.LINK_FILE);
					 * hp.setAddress(FullAddress); cell.setHyperlink(hp);
					 * cell.setCellStyle(hlink_style); } catch (IOException e) {
					 * e.printStackTrace(); }
					 */
					screenShot();
					hlink_style.setFont(hlink_font);
					String FullAddress = ImagePath + i + ".PNG";
					File f2 = new File(FullAddress);
					String windowsPath = f2.toURI().toString();
					Hyperlink hp = createHelper
							.createHyperlink(Hyperlink.LINK_FILE);
					hp.setAddress(windowsPath);
					cell.setHyperlink(hp);
					cell.setCellStyle(hlink_style);

					cell.setCellValue(headers1[j]);
				} else {
					cell.setCellValue(headers1[j]);
				}
			}
			try {
				FileOutputStream out = new FileOutputStream(new File(Filepath));
				workbook.write(out);
				out.close();
				System.out
						.println("javahabitExcelDemo.xlsx Successfully created");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			XSSFWorkbook workbook1;
			try {
				FileInputStream out1 = new FileInputStream(new File(Filepath));
				workbook1 = new XSSFWorkbook(out1);
				XSSFSheet sheet1 = workbook1.getSheetAt(0);
				Row row = sheet1.createRow(i);
				String[] headers = { x, y, z.toString() };
				for (int j = 0; j < 3; j++) {
					Cell cell = row.createCell(j);
					if (headers[j].equalsIgnoreCase("Pass")) {
						XSSFCellStyle style = workbook1.createCellStyle();
						CreationHelper createHelper = workbook1
								.getCreationHelper();
						CellStyle hlink_style = workbook1.createCellStyle();
						Font hlink_font = workbook1.createFont();
						hlink_font.setUnderline(Font.U_SINGLE);
						hlink_font.setColor(IndexedColors.GREEN.getIndex());
						/*
						 * File scrFile =
						 * ((TakesScreenshot)driver).getScreenshotAs
						 * (OutputType.FILE); try { String
						 * FullAddress=ImagePath+i+".PNG";
						 * System.out.println(FullAddress);
						 * FileUtils.copyFile(scrFile, new File(FullAddress));
						 * hlink_style.setFont(hlink_font);
						 * 
						 * Hyperlink hp =
						 * createHelper.createHyperlink(Hyperlink.LINK_FILE);
						 * hp.setAddress(FullAddress); cell.setHyperlink(hp);
						 * cell.setCellStyle(hlink_style);
						 * 
						 * } catch (IOException e) { e.printStackTrace(); }
						 */
						screenShot();
						hlink_style.setFont(hlink_font);
						String FullAddress = ImagePath + i + ".PNG";
						File f2 = new File(FullAddress);
						String windowsPath = f2.toURI().toString();
						Hyperlink hp = createHelper
								.createHyperlink(Hyperlink.LINK_FILE);
						hp.setAddress(windowsPath);
						cell.setHyperlink(hp);
						cell.setCellStyle(hlink_style);

						cell.setCellValue(headers[j]);
					} else if (headers[j].equalsIgnoreCase("Fail")) {
						XSSFCellStyle style = workbook1.createCellStyle();
						CreationHelper createHelper = workbook1
								.getCreationHelper();
						CellStyle hlink_style = workbook1.createCellStyle();
						Font hlink_font = workbook1.createFont();
						hlink_font.setUnderline(Font.U_SINGLE);
						hlink_font.setColor(IndexedColors.RED.getIndex());
						/*
						 * File scrFile =
						 * ((TakesScreenshot)driver).getScreenshotAs
						 * (OutputType.FILE); try { String
						 * FullAddress=ImagePath+i+".PNG";
						 * System.out.println(FullAddress);
						 * FileUtils.copyFile(scrFile, new File(FullAddress));
						 * hlink_style.setFont(hlink_font);
						 * 
						 * Hyperlink hp =
						 * createHelper.createHyperlink(Hyperlink.LINK_FILE);
						 * hp.setAddress(FullAddress); cell.setHyperlink(hp);
						 * cell.setCellStyle(hlink_style);
						 * 
						 * } catch (IOException e) { e.printStackTrace(); }
						 */
						screenShot();
						hlink_style.setFont(hlink_font);
						String FullAddress = ImagePath + i + ".PNG";
						File f2 = new File(FullAddress);
						String windowsPath = f2.toURI().toString();
						Hyperlink hp = createHelper
								.createHyperlink(Hyperlink.LINK_FILE);
						hp.setAddress(windowsPath);
						cell.setHyperlink(hp);
						cell.setCellStyle(hlink_style);

						cell.setCellValue(headers[j]);
					} else {

						cell.setCellValue(headers[j]);
					}

				}
				out1.close();
				FileOutputStream out = new FileOutputStream(new File(Filepath));
				workbook1.write(out);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		i++;

	}

	public enum status {
		Pass, Fail, Done, Warning, Debug;
	}

}
