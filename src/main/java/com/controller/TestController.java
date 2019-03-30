package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.FtlToDocDowload;
import com.service.IStudentService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("testController")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private FtlToDocDowload ftlToDocDowload;
    @Autowired
    private IStudentService iStudentService;

    @RequestMapping(value = "download/excel", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject ceshi(HttpServletResponse response) {
        JSONObject result = new JSONObject();
        try {
            iStudentService.downloadExcel(response);
            result.put("message", "success");
        } catch (Exception e) {
            logger.info("下载失败");
            result.put("message", "error");
        }
        return result;

    }

    @RequestMapping(value = "view", method = RequestMethod.POST)
    public @ResponseBody
    JSONObject ceshi(@RequestBody List<JSONObject> students) {
        JSONObject result = new JSONObject();
        try {
            iStudentService.insertStudent(students);
            result.put("message", "success");
        } catch (Exception e) {
            logger.info("保存失败");
            result.put("message", "error");
        }
        return result;

    }

    @RequestMapping(value = "test/upload", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject upload(@RequestParam("file") MultipartFile attach, HttpServletRequest request) {
        String savepath = request.getSession().getServletContext().getRealPath("upload");
        if (!attach.isEmpty()) {
            File savefile = new File(savepath + "/" + attach.getOriginalFilename());
            try {
                FileUtils.copyInputStreamToFile(attach.getInputStream(), savefile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            request.setAttribute("message", "文件上传成功");
        }
        JSONObject result = new JSONObject();
        result.put("message", "文件上传成功");
        return result;
    }

    @RequestMapping(value = "test/downLoadFile", method = RequestMethod.GET)
    public void downLoadFile(HttpServletResponse response, HttpServletRequest request) {
        //String[] classpath= this.getClass().getResource("/").getPath().split("WEB-INF");
        try {
            String path = request.getSession().getServletContext().getRealPath("resources") + "/bg.png";
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            logger.error("文件未找到" + ex);
        }
    }

    @RequestMapping(value = "test/downLoadFile_doc", method = RequestMethod.GET)
    public void downLoadDoc(HttpServletResponse response, HttpServletRequest request) {
        JSONObject param = new JSONObject();
        param.put("name", "李寻欢");
        param.put("position", "探花");
        ftlToDocDowload.downLoadDoc("word下载.doc", "wordftl.ftl", param, request, response);
    }


}
