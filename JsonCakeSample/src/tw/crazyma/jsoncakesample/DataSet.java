package tw.crazyma.jsoncakesample;


public class DataSet {
	private String status;
	private Data data;
	
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "status : " + status
				   + "\n" + data.toString();
		return str;
	}


	private class Data{
		
		private String userID,description,itemID;
		private int itemKind,value;
		
		public String getUserID() {
			return userID;
		}
		public void setUserID(String userID) {
			this.userID = userID;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getItemID() {
			return itemID;
		}
		public void setItemID(String itemID) {
			this.itemID = itemID;
		}
		public int getItemKind() {
			return itemKind;
		}
		public void setItemKind(int itemKind) {
			this.itemKind = itemKind;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String str = "userID : " + userID 
					   + "\ndescription : " + description;
			return str;
		}
	}
	
}
