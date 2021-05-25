package h2;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        H2CreateExample.execute();
        H2InsertExample.execute();
        H2SelectExample.execute();
        H2UpdateExample.execute();
        H2DeleteExample.execute();
    }
}
