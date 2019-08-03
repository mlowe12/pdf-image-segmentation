package com.mlowe12.github.pdfdoc;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.BufferedInputStream;
import java.awt.image.BufferedImage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;


public class PdfHandler {

    private InputStream inputstream;
    private PDDocument pddocument;
    public String instanceId;
    public Map<String, byte[]> images;

    public PdfHandler() {
        this.inputstream = null;
        this.pddocument = null;
        this.instanceId = null;
        this.images = new HashMap<>();
    }

    public void processImage(InputStream inputstream) {
        return;
    }
}