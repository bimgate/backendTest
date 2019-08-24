package qa.tests;

import com.jayway.restassured.RestAssured;
import entities.Posts;
import entities.Users;
import helpers.TestBase;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import utility.ValidateValue;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.when;

public class ValidateEmails extends TestBase {

    public String USER_NAME = "Samantha";

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Step
    public Integer userDataUserName(String user) throws Exception {
        Integer userId = null;

        Response<List<Users>> response = testApi.getUser().execute();
        if (response.isSuccessful()) {

            Integer numberOfUsers = response.body().size();

            for (int i = 0; i < numberOfUsers; i++) {
                String userName = response.body().get(i).getUsername();
                if (userName.equals(user)) {
                    userId = response.body().get(i).getId();

                }
            }


        } else {
            throw new Exception(response.errorBody().string());
        }
        return userId;
    }

    @Step
    public List userDataPosts(Integer userId) throws Exception {
        List postsIDs = new ArrayList();

        Response<List<Posts>> response = testApi.getPosts(userId).execute();
        if (response.isSuccessful()) {

            Integer numberOfPosts = response.body().size();

            for (int i = 0; i < numberOfPosts; i++) {
                Integer postID = response.body().get(i).getId();
                postsIDs.add(postID);
            }
        } else {
            throw new Exception(response.errorBody().string());
        }
        return postsIDs;
    }


   @Test
    public void testPost() throws Exception {

        Integer userId = userDataUserName(USER_NAME);
        List allUserPosts = userDataPosts(userId);

        SoftAssertions softly = new SoftAssertions();

        for (int i = 0; i<allUserPosts.size(); i++) {
          List bodyComment = when().
            get("/comments?postId={id}", allUserPosts.get(i)).
            then().
            statusCode(200).extract().body().path("email");

            for (int x=0; x<bodyComment.size(); x++) {
                Boolean testB = new ValidateValue().isValidEmailAddress("fsedf.com");
                softly.assertThat(testB).as("Email: %s from postId %s", bodyComment.get(x), allUserPosts.get(i)).isTrue();
            }
        }
        softly.assertAll();
    }
}