package com.mlowe12.github.pdfdoc;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;


public class PdfHandler {


    public static Map<String, byte[]> generateInputStream(InputStream stream) {

        final Map<String, byte[]> documents = new HashMap<>();

        InputStream inputStream =  new BufferedInputStream(stream);

        try(final PDDocument document = PDDocument.load(inputStream)) {

            PDFRenderer renderer = new PDFRenderer(document);
            
            int pageCount = document.getNumberOfPages();

            for(int i = 0; i < pageCount; ++i) {

                BufferedImage buffer = renderer.renderImageWithDPI((i), 500, ImageType.GRAY);

                String pageNumber = String.format("%d", i);

                ByteArrayOutputStream tmpOutput = new ByteArrayOutputStream();
                
                ImageIO.write(buffer, "png", tmpOutput );
                
                tmpOutput.flush();
                
                byte[] pngDocument = tmpOutput.toByteArray();
                
                tmpOutput.close();

                documents.put(pageNumber,pngDocument);
            }

            document.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return documents;
    }
}