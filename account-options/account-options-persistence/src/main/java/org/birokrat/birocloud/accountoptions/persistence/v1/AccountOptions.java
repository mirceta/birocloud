package org.birokrat.birocloud.accountoptions.persistence.v1;

import org.eclipse.persistence.annotations.UuidGenerator;
import javax.persistence.*;


@Entity(name = "accountoptions")
@NamedQueries(value =
        {
                @NamedQuery(name = "accountoptions.getAll", query = "SELECT ao FROM accountoptions ao")
        })
@UuidGenerator(name = "idGenerator")
public class AccountOptions {

    @Id
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "option_key")
    private String key;

    @Column(name = "option_value")
    private String value;

    // getter and setter methods
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getKey() {
        return this.key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return this.value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}