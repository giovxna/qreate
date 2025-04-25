# 📦 QCreate - QR Code Generator API

QCreate is a RESTful API built with Spring Boot that allows users to generate QR codes from any text input. Once generated, the image is uploaded to an AWS S3 bucket and a public URL is returned.

This project was built with clean architecture principles in mind, using interfaces (ports) and adapters to separate concerns and ensure flexibility and testability.

## What It Does

- Accepts text input and generates a QR code (PNG format)
- Uploads the generated image to a specified AWS S3 bucket
- Returns a public URL to access the QR code image

## Tech Stack

- Java 21
- Spring Boot
- ZXing (QR code generation)
- AWS SDK v2 (S3 integration)
- Docker (multi-stage image for build + run)
- Clean Architecture (Ports & Adapters pattern)

## Running the Project

You can run QCreate either **locally via Maven** or using **Docker**.

### 1. Prerequisites

- Java 21
- Maven 3.9+
- AWS S3 bucket and credentials with permission to upload objects
- Docker (optional, if using container)

### 2. Environment Variables

Create a `.env` file in your project root **(not committed to Git)** with:

```env
AWS_ACCESS_KEY_ID=your-access-key
AWS_SECRET_ACCESS_KEY=your-secret-key
AWS_REGION=us-east-1
AWS_S3_BUCKET=your-s3-bucket-name
These variables are injected at runtime when using Docker or can be set via your IDE/environment for local execution.
```

3. Run Locally (Maven)
```
mvn spring-boot:run
Access the API at: http://localhost:8080/qrcode
```

4. Run with Docker
```
docker build -t qcreate .
docker run -p 8080:8080 \
  -e AWS_ACCESS_KEY_ID=your-access-key \
  -e AWS_SECRET_ACCESS_KEY=your-secret-key \
  -e AWS_REGION=us-east-1 \
  -e AWS_S3_BUCKET=your-s3-bucket-name \
  qcreate
```

## How to Use the API + Generate QR Code

<b>POST /qrcode</b>

Request:
```
{
  "text": "https://example.com"
}
```

Response:
```
{
  "url": "https://your-bucket-name.s3.us-east-1.amazon.com/generated-file.png"
}
```
