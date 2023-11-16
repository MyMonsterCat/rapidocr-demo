package io.github.mymonstercat;

import com.benjaminwan.ocrlibrary.OcrResult;
import io.github.monster.ocr.InferenceEngine;
import io.github.monster.ocr.Model;
import io.github.monster.ocr.config.ParamConfig;

import java.io.File;

/**
 * @author Monster
 */
public class Main {
    public static void main(String[] args) {
        ParamConfig paramConfig = ParamConfig.getDefaultConfig();
        paramConfig.setDoAngle(true);
        paramConfig.setMostAngle(true);
        InferenceEngine engine = InferenceEngine.getInstance(Model.ONNX_PPOCR_V3);
        // 开始识别
        OcrResult ocrResult = engine.runOcr(getResourcePath("/images/test.png"), paramConfig);
    }

    private static String getResourcePath(String path) {
        return new File(Main.class.getResource(path).getFile()).toString();
    }
}
