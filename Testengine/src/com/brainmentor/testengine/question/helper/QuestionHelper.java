package com.brainmentor.testengine.question.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.brainmentor.testengine.question.dao.QuestionDAO;
import com.brainmentor.testengine.question.dto.QuestionDTO;
import com.brainmentor.testengine.util.pathconstant.PathConstants;
import com.brainmentor.testengine.utils.CommonUtils;






public class QuestionHelper {
	
	public void writeInDB(String path) throws IOException {
		 boolean FirstRowPass=false;
		 int CellCounter=0;
		ArrayList<QuestionDTO> questionlist = new  ArrayList<> ();
		FileInputStream fi = new FileInputStream(path);
		HSSFWorkbook workbook = new HSSFWorkbook(fi);
		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator <Row> rows = sheet.rowIterator();
		 while(rows.hasNext())
		 {
			 Row currentrow=rows.next();
			 if(!FirstRowPass) {
				 FirstRowPass=true;
				 continue;
				 
			 }
				 
			 CellCounter=0;
			 QuestionDTO questionDTO =new QuestionDTO();
			 Iterator<Cell> cell= currentrow.cellIterator();
			 while(cell.hasNext()) {
				 
				 Cell currentCell = cell.next();

					CellCounter++;

					if(CellCounter==1){

						questionDTO.setId((int)currentCell.getNumericCellValue());

					}

					else

					if(CellCounter==2){

						questionDTO.setName(currentCell.getStringCellValue());

					}

					else

						if(CellCounter==3){

							questionDTO.setAns1(currentCell.getStringCellValue());

						}

						else

							if(CellCounter==4){

								questionDTO.setAns2(currentCell.getStringCellValue());

							}

							else

								if(CellCounter==5){

									questionDTO.setAns3(currentCell.getStringCellValue());

								}

								else

									if(CellCounter==6){

										questionDTO.setAns4(currentCell.getStringCellValue());

									}

									else

										if(CellCounter==7){

											questionDTO.setRans(currentCell.getStringCellValue());

										}

										else

											if(CellCounter==8){

												questionDTO.setScore((int)currentCell.getNumericCellValue());

											}

					

					

				} // Cell Loop Ends

				questionlist.add(questionDTO);
		 }
		QuestionDAO questionDAO = new QuestionDAO();
		try {
			questionDAO.bulkUpload(questionlist);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}
 
	//public void write() {
		//String path = C:\Users\Yash Sharma\eclipse-workspace\Testengine\src 
	//}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuestionHelper helper = new QuestionHelper();
	//	helper.write();

	}
	
	
	
	
	public boolean read (String path) throws IOException
	{  boolean isUpload =false;
		File file =new File(path);
		String filename=CommonUtils.getFileName(path);
		String fullfileName=PathConstants.Upload_Path+filename;
		FileOutputStream fo= new FileOutputStream(fullfileName);
	    BufferedOutputStream bo= new BufferedOutputStream(fo);
	     final int EOF=-1;
	     if (file.exists())
	     {
	    	 System.out.println("..Exist..");
	    	 FileInputStream fs = new FileInputStream(path);

	 		BufferedInputStream bs = new BufferedInputStream(fs);

	 	//	long startTime = System.currentTimeMillis();

	 		int singleByte = bs.read(); // read single byte

	 		while(singleByte!=EOF) {

	 			bo.write(singleByte);

	 			//System.out.print((char)singleByte);

	 			 singleByte = bs.read();

	    	 
	    	
	     }
	isUpload=true;
	bo.close();
	fo.close();

	bs.close();

	fs.close();
	writeInDB(fullfileName);

	
	     }
		return isUpload;
	     
	}	

}


