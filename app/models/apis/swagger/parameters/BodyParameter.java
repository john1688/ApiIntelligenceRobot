package models.apis.swagger.parameters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import models.apis.swagger.Model;
import services.utils.JacksonFactory;

import java.util.HashMap;
import java.util.Map;

public class BodyParameter extends AbstractParameter implements Parameter {
    Model schema;
    Map<String, String> examples;

    public BodyParameter() {
        super.setIn("body");
    }

    public BodyParameter schema(Model schema) {
        this.setSchema(schema);
        return this;
    }

    public BodyParameter example(String mediaType, String value) {
        this.addExample(mediaType, value);
        return this;
    }

    public BodyParameter description(String description) {
        this.setDescription(description);
        return this;
    }

    public BodyParameter name(String name) {
        this.setName(name);
        return this;
    }

    public Model getSchema() {
        return schema;
    }

    public void setSchema(Model schema) {
        this.schema = schema;
    }

    public void addExample(String mediaType, String value) {
        if(examples == null) {
            examples = new HashMap<String, String>();
        }
        examples.put(mediaType, value);
    }

    @JsonProperty("x-examples")
    public Map<String, String> getExamples() {
        return examples;
    }

    public void setExamples(Map<String, String> examples) {
        this.examples = examples;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((schema == null) ? 0 : schema.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BodyParameter other = (BodyParameter) obj;
        if (schema == null) {
            if (other.schema != null) {
                return false;
            }
        } else if (!schema.equals(other.schema)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        Map<String,Object> map = new HashMap<>();
//        map.put(this.name,this.examples);
        String result = "";
        try {
            result = JacksonFactory.getMapperInstance(false).writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;

    }
}