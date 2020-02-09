package edu.taller.sisgea.consultasgenerales.service.subreporttmp;

import java.io.ByteArrayOutputStream;

import lombok.Data;


@Data
public class SubReportTmp {
	String fileName;
	ByteArrayOutputStream bos;
}