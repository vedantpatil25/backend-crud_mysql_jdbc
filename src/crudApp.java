public class crudApp {
    public static void main(String args[])
    {
        stock barclays = new stock();
        barclays.CreateDatabase();
        barclays.createTable();
        barclays.insertData();
        barclays.readData();
        barclays.updateData();
        barclays.deleteData();
    }
}
