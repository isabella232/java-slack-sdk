package test_locally.api.model.event;

import com.google.gson.Gson;
import com.slack.api.model.event.TeamProfileDeleteEvent;
import org.junit.Test;
import test_locally.unit.GsonFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TeamProfileDeleteEventTest {

    @Test
    public void typeName() {
        assertThat(TeamProfileDeleteEvent.TYPE_NAME, is("team_profile_delete"));
    }

    @Test
    public void deserialize() {
        String json = "{\n" +
                "    \"type\": \"team_profile_delete\",\n" +
                "    \"profile\": {\n" +
                "        \"fields\": [\n" +
                "            {\n" +
                "                \"id\": \"Xf06054AAA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}\n";
        TeamProfileDeleteEvent event = GsonFactory.createSnakeCase().fromJson(json, TeamProfileDeleteEvent.class);
        assertThat(event.getType(), is("team_profile_delete"));
        assertThat(event.getProfile(), is(notNullValue()));
    }

    @Test
    public void serialize() {
        Gson gson = GsonFactory.createSnakeCase();
        TeamProfileDeleteEvent event = new TeamProfileDeleteEvent();
        String generatedJson = gson.toJson(event);
        String expectedJson = "{\"type\":\"team_profile_delete\"}";
        assertThat(generatedJson, is(expectedJson));
    }

}
