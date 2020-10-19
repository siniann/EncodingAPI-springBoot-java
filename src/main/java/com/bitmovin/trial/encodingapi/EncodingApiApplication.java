package com.bitmovin.trial.encodingapi;

import com.bitmovin.trial.encodingapi.downloadmanager.FileDownloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class EncodingApiApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(EncodingApiApplication.class, args);
		Encoding enc = context.getBean(Encoding.class);

		List<Encoding> list = enc.get100EncodingList();
		enc.sortEncodingsByPriority(list);

		FileDownloader.fileDownloadImplementation("http://speed.hetzner.de/100MB.bin");
		FileDownloader.fileDownloadUsingAPI();

	}

}
