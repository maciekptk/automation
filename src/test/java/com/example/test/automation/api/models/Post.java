package com.example.test.automation.api.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Post {

  int id;
  String title;
  String body;
  int userId;
}
