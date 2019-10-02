package com.example.demo;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

@Controller
public class ImageProcessing {

	@RequestMapping("/test")
	public void test() {
		System.out.println(getImgText("/home/shivasantosh/Desktop/test.jpg"));
	}
	
	public String getImgText(String imageLocation) {
	      ITesseract instance = new Tesseract();
//	      instance.setDatapath("tessdata");
	      File tess = LoadLibs.extractTessResources("tessdata"); 
	      instance.setDatapath("/tmp/tess4j/tessdata");
	      instance.setLanguage("eng");
	      try 
	      {
	         String imgText = instance.doOCR(new File(imageLocation));
	         return imgText;
	      } 
	      catch (TesseractException e) 
	      {
	         e.getMessage();
	         return "Error while reading image";
	      }
	   }
	
	public static void main(String[] args) {
		ImageProcessing img = new ImageProcessing();
		System.out.println(img.getImgText("/home/shivasantosh/Desktop/ocr.png"));
	}
}
