# 📦 Qreate - QR Code Generator API

**Technologies**:  
Java • Spring Boot • AWS SDK • Google ZXing • Docker • Maven  

RESTful API in Spring Boot for QR code generation with AWS S3 storage, developed with Clean Architecture principles (Ports & Adapters).

## Features
- Generates QR codes in PNG (200×200 pixels) from any text
- Automatically stores images in S3 bucket
- Returns public URL to access the QR code

## How to Run

### Prerequisites
- Java 21 JDK
- Maven 3.9+
- Docker (optional)
- AWS account with:
  - Configured S3 bucket
  - Programmatic access credentials
  - AWS CLI configured (for local development)

### Environment Variables

Create a `.env` file in the project root with:

```
AWS_ACCESS_KEY_ID=your_access_key
AWS_SECRET_ACCESS_KEY=your_secret_key
AWS_REGION=aws_region
AWS_S3_BUCKET=bucket_name
```

Locally (Maven)
```
mvn clean package
mvn spring-boot:run
```

Via Docker
Build the image:

```
docker build -t qcreate:X.X .
```
(Replace X.X with desired version)

Run the container:

```
docker run --env-file .env -p 8080:8080 qcreate:X.X
```

##  API Documentation

<b>POST /qrcode</b></br>
Generates QR code and stores it in S3.

Success Response:

```
{
  "url": "https://your-bucket.s3.region.amazonaws.com/file.png"
}
```
