
package jsonmodel;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "A",
    "B"
})
public class Message {

    @JsonProperty("A")
    private String a;
    @JsonProperty("B")
    private B b;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("A")
    public String getA() {
        return a;
    }

    @JsonProperty("A")
    public void setA(String a) {
        this.a = a;
    }

    @JsonProperty("B")
    public B getB() {
        return b;
    }

    @JsonProperty("B")
    public void setB(B b) {
        this.b = b;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
