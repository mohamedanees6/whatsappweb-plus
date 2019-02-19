package com.anees.develop.whatsapp;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.Scanner;

import net.bytebuddy.utility.RandomString;

public class WhatsappScrape {
  public static void main(String args[]) throws Exception {
    ChromeDriver cd = new ChromeDriver();
    cd.get("http://web.whatsapp.com");
    System.out.println(
        "Scan the QR Code in your phone. Login -> Then click the group/contact to send the message to");
    System.out.println("Press Y when done");
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    if (input.equalsIgnoreCase("y")) {
      while (true) {
        System.out.println("Enter the message");
        String message = sc.nextLine();
        if (message.equalsIgnoreCase("exit")) {
          break;
        } else if (message.equalsIgnoreCase("<3")) {
          for (int i = 0; i < 10; i++) {
            long numHearts = new Random().nextInt(10);
            StringBuilder sb = new StringBuilder("<3");
            while (numHearts > 0) {
              sb.append(" <3");
              numHearts--;
            }
            sendToWhatsapp(cd, sb);
          }
        } else if (message.equalsIgnoreCase("spam")) {
          System.out.println("Spamming the chat!");
          for (int i = 0; i < 20; i++) {
            message = new RandomString().nextString();
            sendToWhatsapp(cd, message);
          }
        } else {
          sendToWhatsapp(cd, message);
        }
      }
    } else {
      System.out.println("Thanks for trying!");
    }
  }

  private static void sendToWhatsapp(ChromeDriver cd, CharSequence sb) {
    cd.findElementByXPath("//*[@id=\"main\"]/footer/div[1]/div[2]/div/div[2]").sendKeys(sb);
    cd.findElementByXPath("//*[@id=\"main\"]/footer/div[1]/div[3]").click();
  }
}
