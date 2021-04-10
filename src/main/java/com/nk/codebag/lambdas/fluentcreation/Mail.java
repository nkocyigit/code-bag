package com.nk.codebag.lambdas.fluentcreation;

import java.util.function.Consumer;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class Mail {
  private String from;
  private String to;
  private String subject;
  private String body;

  private Mail() {}

  public Mail from(String from){
    this.from = from;
    return this;
  }

  public Mail to(String to){
    this.to = to;
    return this;
  }

  public Mail subject(String subject){
    this.subject = subject;
    return this;
  }

  public Mail body(String body){
    this.body = body;
    return this;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("from",from)
        .append("to",to)
        .append("subject", subject)
        .append("body", body)
        .build();
  }

  public static void send(Consumer<Mail> sender) {
    var mail = new Mail();
    sender.accept(mail);
  }

  public static void main(String[] args) {
    send(mail -> toStringConsumer(mail
        .from("test1")
        .to("test2")
        .subject("test3")
        .body("test4")));
  }

  @SuppressWarnings("squid:S106") // system.out
  private static void toStringConsumer(Mail mail) {
    System.out.println(mail);
  }
}
