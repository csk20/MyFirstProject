package com.qolsys.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;


import com.qolsys.bo.RegisterBO;
import com.qolsys.bo.UserBO;
import com.qolsys.dao.RegisterDAOImpl;
import com.qolsys.dto.RegisterDTO;
import com.qolsys.dto.UserDTO;
@Component
public class ExcelView extends AbstractXlsView {

	
	
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		Sheet sheet=null;
		Row row=null;
	int i=0,j=0;
	
	List<UserDTO>  ldto;
	ldto=(List<UserDTO>) model.get("userList");
	sheet=workbook.createSheet("excelSheet");
	for (UserDTO userBO : ldto) {
		j=0;
		row=(Row) sheet.createRow(i);
		row.createCell(j).setCellValue("  "+String.valueOf(i+1)+"  ");
	  row.createCell(j+1).setCellValue("  "+userBO.getUser()+"  ");
	  row.createCell(j+2).setCellValue("  "+userBO.getPwd()+"  ");
		i++;
	}
	

	}

}
