package bc.desafio_spring.meli_social.dto;


public class CreateBuyerRequestDTO {
    private String name;

    CreateBuyerRequestDTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
