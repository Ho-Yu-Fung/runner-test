package com.example.runnertest.other;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class good {
    public static void main(String[] args) {
        new good().test();
    }
    public String test(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("W:/og.docx"));
            fileOutputStream = new FileOutputStream(new File("W:/des.docx"));
            XWPFDocument document = new XWPFDocument(fileInputStream);
            XWPFDocument out = new XWPFDocument();
            List<XWPFParagraph> paragraph = document.getParagraphs();
            ArrayList<Object> objects = new ArrayList<>();
            for(int i = 1 ; i <paragraph.size();i++){

            }
            for (XWPFParagraph parag : paragraph ){
                List<XWPFRun> runs = parag.getRuns();
//                parag.setFontAlignment(3);
//                List<XWPFRun> runs = parag.getRuns();
//                XWPFParagraph paragraphOut = out.createParagraph();
//                paragraphOut.setFontAlignment(3);
                for(XWPFRun run : runs){

                    run.setText(parag.getText());
                    run.setFontFamily("黑体");
                    run.setFontSize(18);
                }
            }
            document.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                System.out.println("close");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
                System.out.println("close");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
