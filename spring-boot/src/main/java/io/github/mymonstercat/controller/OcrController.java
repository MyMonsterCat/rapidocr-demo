package io.github.mymonstercat.controller;

import com.benjaminwan.ocrlibrary.OcrResult;
import io.github.monster.ocr.InferenceEngine;
import io.github.monster.ocr.config.ParamConfig;
import io.github.mymonstercat.Model;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Monster
 */
@RestController
@RequestMapping("/ocr")
public class OcrController {

    @GetMapping()
    public String ocr() {
        ParamConfig paramConfig = ParamConfig.getDefaultConfig();
        paramConfig.setDoAngle(true);
        paramConfig.setMostAngle(true);
        InferenceEngine engine = InferenceEngine.getInstance(Model.ONNX_PPOCR_V3);
        // 开始识别
        OcrResult ocrResult = engine.runOcr(getResourcePath("images/test.png"), paramConfig);
        return ocrResult.getStrRes().toString();
    }


    @SneakyThrows
    private static String getResourcePath(String path) {
        return Thread.currentThread().getContextClassLoader().getResource(path).getPath();
    }
}
