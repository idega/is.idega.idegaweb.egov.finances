package is.idega.idegaweb.egov.finances.data;

public class EntryType {
	private int typeId = -1;
	
	private String type = null;
	
	private String description = null;
	
	public EntryType(int id, String type, String description) {
		this.typeId = id;
		this.type = type;
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTypeId() {
		return this.typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}