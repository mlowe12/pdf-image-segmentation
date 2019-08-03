package com.mlowe12.services.pdfservice;

import java.util.Map;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mlowe12.github.pdfdoc.PdfHandler;

@RestController
public class Controller {
    @RequestMapping(method=RequestMethod.POST,value="/api/v1/upload")
    public @ResponseBody Map<String, byte[]> uploadFile(@RequestParam(value="uploadFile", required=false) MultipartFile file) throws IOException {
         Map<String, byte[]> documents = PdfHandler.generateInputStream(file.getInputStream());
         documents.forEach((k,v) -> {
             System.out.println(k);
         });
         return documents;
    }
}