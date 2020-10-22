package com.example.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

	@RequestMapping(path = "/d2", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download_2(@RequestParam int key) throws Exception {
		if (key % 2 == 0) {
			Resource rs = new ClassPathResource("/abc.jpg");
			byte[] picData = FileCopyUtils.copyToByteArray(rs.getInputStream());
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attchement;filename=abc-" + key + ".jpg");
			ResponseEntity<byte[]> re = new ResponseEntity<>(picData, headers, HttpStatus.OK);
			return re;
		} else {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attchement;filename=abc-" + key + ".jpg");
			ResponseEntity<byte[]> re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return re;
		}
	}

	@RequestMapping(path = "/d1", method = RequestMethod.GET)
	@ResponseBody
	public byte[] download_1(@RequestParam int key, HttpServletResponse response) throws Exception {
		// ResponseEntity<byte[]>
		if (key % 2 == 0) {
			Resource rs = new ClassPathResource("/abc.jpg");
			response.setHeader("Content-Disposition", "attchement;filename=ABC-" + key + ".jpg");
			byte[] picData = FileCopyUtils.copyToByteArray(rs.getInputStream());
			return picData;
		} else {
			return null;
		}
	}

}
