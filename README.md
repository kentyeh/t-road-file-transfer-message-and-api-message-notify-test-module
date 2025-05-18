## 資料安全傳輸驗證系統
> 機關資訊系統間的資料傳輸以 T-Road 的安控伺服器 (Secure Server，以下簡稱 SS) 進行傳輸時，因實體隔離的內部網路環境，技術人員不容易取得測試訊息進行問題分析的困境；透夠過本系統提供跨機關介接 SS 之驗證服務，可以驗證資訊傳輸是否符合介接訊息規格及應用程式介面 (API) 規範，解決在封閉網路環境下無法取得完整資訊分析的問題，進而加速跨機關間透過 T-Road 進行安全資料傳輸的轉換。因此，透過本系統可協助開發人員在處理跨機關資訊系統介接時，於實體隔離的封閉網路情境下，仍能配合以安全的方式進行測試除錯，進而加速各業務系統轉換介接 T-Road。

## 1.使用技術
Spring Boot

## 2.安裝指南
> 請確保您的環境中安裝有 Java 22 及 Maven 3 以上版本
執行步驟
```bat
> git clone https://github.com/TsubasaRush/t-road-file-transfer-message-and-api-message-notify-test-module.git
> cd t-road-file-transfer-message-and-api-message-notify-test-module
REM 開發時期除快速執行
> mvn clean spring-boot:run
REM 開啟 http://localhost:8080/swagger-ui/index.html 參考API文件 
REM 建置專案
> mvn clean package
REM 建置建置後執行專案
> java -jar target/demotroad.war 
```
將程式建置為 war 包，並且於本機或需求的主機上執行該 war，
或者將 target/demotroad.war.original 更名為 demotroad.war 可Deploy到 Web Server，
服務將預設啟動於 8080 port，若有其他需求可於 application.properties 設定
可於 http://localhost:8080/client 下模擬
troad /apiService, /createFileTransfer, /startFileTransfer
服務呼叫，並列印相關內容供查驗

## 3.使用情境範例
> 模擬使用者呼叫 T-Road SS api 服務
-使用程式組成 T-Road 物件呼叫 http://localhost:8080/client/apiService
參考 T-Road API 文件開發程式進行呼叫
T-Road 物件範例
```plaintext
\\於header中加入 由數發部提供的client_api_key (client_api_key)
{
      "agreementId": "由數發部提供的agreementId",
  "requestBody": "Base64過的請求訊息",
  "requestBy": "",
  "requestHeaders": {
    "additionalProp1": "",
    "additionalProp2": ""
  },
  "requestMethod": "POST",
  "ticketNo": ""
}
```
## 4.結果展示
- 使用程式組成 T-Road 物件呼叫 http://localhost:8080/client/apiService
參考 T-Road API 文件開發程式進行呼叫
回覆
```plaintext
{
  "code": 200,
  "message": "OK",
  "responseCode": 200,
  "result": "5qGI5Lu25ZG85Y+r5oiQ5Yqf",
  "ticketNo": "string"
}

```
- 使用 Postman 驗測資料正確性
設定 header 內的 client-api-key
設定 json
```plaintext
{
  "agreementId": "由數發部提供的agreementId",
  "requestBody": "Base64過的請求訊息",
  "requestBy": "",
  "requestHeaders": {
    "additionalProp1": "",
    "additionalProp2": ""
  },
  "requestMethod": "POST",
  "ticketNo": ""
}
```
回覆
```plaintext
{
  "code": 200,
  "message": "OK",
  "responseCode": 200,
  "result": "5qGI5Lu25ZG85Y+r5oiQ5Yqf",
  "ticketNo": "string"
}

```

* 使用 Curl 驗測資料正確性
 ```bash
curl -X POST -H "Content-Type: application/json" \
     -H "client_api_key: Hello"- \
     d '{"agreementId":"由數發部提供的agreementId","requestBody":"SGVsbG8gVC1Sb2Fk","requestBy":"","requestHeaders":{"additionalProp1":"","additionalProp2":""},"requestMethod":"POST","ticketNo":""}' http://localhost:8080/client/apiService

回覆
```plaintext
{
  "code": 200,
  "message": "OK",
  "responseCode": null,
  "result": "5qGI5Lu25ZG85Y+r5oiQ5Yqf",
  "responseHeaders": "nullh"
}
 ```

## 5.模組簡介

本模組提供一個模擬 T-Road SS API 的服務，以供測試時檢驗接收及傳輸的請求是否符合數發部規範
並提供部分訊息的 Base64 轉換並列印轉換前的內容供使用者更快速的分辨訊息內容
及多數必要參數之檢核，以達到數發部 T-Road SS API 更加擬真的測試模擬。

JDK: Java 22
框架: Spring Boot v3.3.2
擴建工具: Maven
