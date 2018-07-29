package com.qolsys.view;

import java.awt.Point;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.dialect.FrontBaseDialect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.qolsys.dto.UserDTO;
@Component
public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	List<UserDTO> ldto=null;
	Table table=null;
	Paragraph para=null;
ldto=(List<UserDTO>) model.get("userList");
int count=ldto.size();
para=new Paragraph("Report Cart",new Font());
para.setAlignment("center");
document.add(para);
table= new Table(3,count);
int i=0;
for (UserDTO userDTO : ldto) {
	i++;
table.addCell(" "+String.valueOf(i));
	table.addCell("   "+userDTO.getUser());
	table.addCell("   "+userDTO.getPwd());	
	
}
document.add(table);

	}

	
	
	

	

}
