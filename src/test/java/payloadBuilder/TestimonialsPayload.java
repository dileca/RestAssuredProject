package payloadBuilder;

import org.json.simple.JSONObject;

public class TestimonialsPayload {

    public JSONObject loginUserPayload(String email, String password) {

        JSONObject loginUser = new JSONObject();
        loginUser.put("email",email);
        loginUser.put("password",password);

        return loginUser;
    }

    public JSONObject addTestimonialPayload(String title, String content, String rating) {

        JSONObject createTestimonial = new JSONObject();
        createTestimonial.put("title",title);
        createTestimonial.put("content",content);
        createTestimonial.put("rating",rating);

        return createTestimonial;
    }

    public JSONObject updateTestimonialPayload(String title, String content, String rating) {

        JSONObject updateTestimonial = new JSONObject();
        updateTestimonial.put("content",content);
        updateTestimonial.put("rating",rating);

        return updateTestimonial;
    }


}
