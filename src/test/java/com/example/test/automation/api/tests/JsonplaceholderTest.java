package com.example.test.automation.api.tests;

import com.example.test.automation.api.models.Post;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static com.example.test.automation.api.utils.RestAssuredUtil.sendGet;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

class JsonplaceholderTest extends BaseTest {

  @Value("${api.endpoints.get-post}")
  private String getPostEndpoint;
  @Value("${api.endpoints.get-all-posts}")
  private String getAllPostsEndpoint;

  @Test
  void shouldGetAllPosts() {
    Response response = sendGet(getAllPostsEndpoint);
    assertThat(response.getStatusCode()).isEqualTo(SC_OK);

    Post[] posts = response.as(Post[].class);
    assertThat(posts).isNotEmpty();
  }

  @Test
  void shouldGetPost() {
    int postId = 1;
    Post post = sendGet(getPostEndpoint, postId)
        .then()
        .statusCode(SC_OK)
        .extract()
        .body()
        .as(Post.class);

    assertThat(post.getId()).isEqualTo(postId);
  }
}
