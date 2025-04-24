package com.giovxna.qcreate.ports;

public interface StoragePort {
    String uploadFile(byte[] fileData, String fileName, String contentType);
}
