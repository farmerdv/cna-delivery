package mall;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Cancellation_table")
public class Cancellation {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;
    private Long oderId;
    private String status;

    @PostPersist
    public void onPostPersist(){
        DeliveryCanceled deliveryCanceled = new DeliveryCanceled();
        BeanUtils.copyProperties(this, deliveryCanceled);
        deliveryCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOderId() {
        return oderId;
    }

    public void setOderId(Long oderId) {
        this.oderId = oderId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
