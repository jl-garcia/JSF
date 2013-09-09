package luacsianlabs.demo.model.dto;

import org.primefaces.model.StreamedContent;

public class Country {
    private String countryId;
    private String countryName;
    private int regionId;
    private String flag;
    private String path;
    private StreamedContent imageFlag;

    public Country() {
    }

    public Country(String id, String name, String nameFlag) {
        this.countryId = id;
        this.countryName = name;
        this.flag = nameFlag;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryName(String CountryName) {
        this.countryName = CountryName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getRegionId() {
        return this.regionId;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }


    public void setImageFlag(StreamedContent imageFlag) {
        this.imageFlag = imageFlag;
    }

    public StreamedContent getImageFlag() {
        return imageFlag;
    }
}
