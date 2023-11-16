package io.github.mymonstercat;

import com.github.monster.ocr.OcrUtil;
import com.github.monster.ocr.config.LibConfig;
import com.github.monster.ocr.config.ParamConfig;

import java.io.File;

/**
 * @author Monster
 */
public class Main {
    public static void main(String[] args) {

        ParamConfig paramConfig = ParamConfig.getDefaultConfig();
        paramConfig.setDoAngle(true);
        paramConfig.setMostAngle(true);

        String imgPath1 = getResourcePath("/images/40.png");
        OcrUtil.runOcr(imgPath1, LibConfig.getOnnxConfig(), paramConfig);

        String imgPath2 = getResourcePath("/images/system.png");
        OcrUtil.runOcr(imgPath2, LibConfig.getOnnxConfig(), paramConfig);

        String imgPath3 = getResourcePath("/images/test.png");
        OcrUtil.runOcr(imgPath3, LibConfig.getOnnxConfig(), paramConfig);
    }

    private static String getResourcePath(String path) {
        return new File(Main.class.getResource(path).getFile()).toString();
    }
}
