# Folio Retriever
Folio Retriever allows you to see the price of a stock ticker or the value of your portfolio in a flash!

Customization of an individual's portfolio through the UI is still under development, but can be editted in the [source code](https://github.com/awhic/folio-retriever/blob/main/src/main/java/quicker/ticker/FolioRetriever.java).

This CLI Java application is a Maven Project. To run the application, ensure your environment variables are set correctly, and maven is installed. For more information, visit the official guide for [Using Maven](https://maven.apache.org/).

Instructions for quickly running the application:
- Pull down the repository in a git bash with the below command:

```bash
git clone https://github.com/awhic/folio-retriever.git
```
- Pick one of the following:
  - In Visual Studio Code or any IDE of your choosing, under Maven > ft > Lifecycle, run 'clean' and 'install', with success.
  - Open a terminal (can also be in a git bash) and run the following commands with success:
      ```bash
      mvn clean
      ```
      ```bash
      mvn install
      ```
- Run the application!
