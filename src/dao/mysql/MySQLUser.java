/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import errorMessage.CodeError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Lucas
 */
public class MySQLUser {

    public static int createUser(User user) {
        int error;
        Connection connectionInstance = null;
        PreparedStatement statementInstance = null;
        String request = "INSERT INTO user(loginMail, password, administrator) VALUES (?, ?, ?);";

        try {
            try {
                connectionInstance = MySQLConnect.getConnection();
            } catch (Exception ex) {
                Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
                error = CodeError.CONNEXION_FAIL;
                return error;
            }

            statementInstance = connectionInstance.prepareStatement(request);
            statementInstance.setString(1, user.getLoginAdressMail());
            statementInstance.setString(2, user.getPassword());
            statementInstance.setBoolean(3, user.isAdministrator());
            int statut = statementInstance.executeUpdate();

            if (statut == 1) {
                error = CodeError.SUCESS;
            } else {
                error = CodeError.FAILLURE;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
            error = CodeError.STATEMENT_EXECUTE_FAIL;
        } finally {
            if (statementInstance != null) {
                try {
                    statementInstance.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
                    error = CodeError.STATEMENT_CLOSE_FAIL;
                }
            }
        }
        return error;
    }

    public static int connectUser(User user) {
        int error;
        Connection connectionInstance = null;
        PreparedStatement statementInstance = null;
        String request = "SELECT count(*), userId, administrator FROM user where loginMail = ? and password = ?;";

        try {
            connectionInstance = MySQLConnect.getConnection();
            if (connectionInstance == null) {
                Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, "CONNEXION_FAIL");
                error = CodeError.CONNEXION_FAIL;
            } else {
                statementInstance = connectionInstance.prepareStatement(request);

                statementInstance.setString(1, user.getLoginAdressMail());
                statementInstance.setString(2, user.getPassword());

                ResultSet result = statementInstance.executeQuery();
                result.next();
                if (result.getInt(1) == 1) {
                    user.setId(result.getInt(2));
                    user.setAdministrator(result.getBoolean(3));
                    error = CodeError.SUCESS;
                } else {
                    error = CodeError.FAILLURE;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
            error = CodeError.STATEMENT_EXECUTE_FAIL;
        } finally {
            if (statementInstance != null) {
                try {
                    statementInstance.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
                    error = CodeError.STATEMENT_CLOSE_FAIL;
                }
            }
        }
        return error;
    }

    public static int updateUser(User user) {
        int error;
        Connection connectionInstance = null;
        PreparedStatement statementInstance = null;
        String request = "UPDATE user set loginMail = ?, password = ?, administrator = ? WHERE userID = ?;";

        try {
            try {
                connectionInstance = MySQLConnect.getConnection();
            } catch (Exception ex) {
                Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
                error = CodeError.CONNEXION_FAIL;
                return error;
            }

            statementInstance = connectionInstance.prepareStatement(request);
            statementInstance.setString(1, user.getLoginAdressMail());
            statementInstance.setString(2, user.getPassword());
            statementInstance.setBoolean(3, user.isAdministrator());
            statementInstance.setInt(4, user.getId());
            int statut = statementInstance.executeUpdate();

            if (statut == 1) {
                error = CodeError.SUCESS;
            } else {
                error = CodeError.FAILLURE;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
            error = CodeError.STATEMENT_EXECUTE_FAIL;
        } finally {
            if (statementInstance != null) {
                try {
                    statementInstance.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
                    error = CodeError.STATEMENT_CLOSE_FAIL;
                }
            }
        }
        return error;
    }

    public static int deleteUser(User user) {
        int error;
        Connection connectionInstance = null;
        PreparedStatement statementInstance = null;
        String request = "DELETE FROM user WHERE userID = ?;";

        try {
            try {
                connectionInstance = MySQLConnect.getConnection();
            } catch (Exception ex) {
                Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
                error = CodeError.CONNEXION_FAIL;
                return error;
            }

            statementInstance = connectionInstance.prepareStatement(request);
            statementInstance.setInt(1, user.getId());
            int statut = statementInstance.executeUpdate();

            if (statut == 1) {
                error = CodeError.SUCESS;
            } else {
                error = CodeError.FAILLURE;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
            error = CodeError.STATEMENT_EXECUTE_FAIL;
        } finally {
            if (statementInstance != null) {
                try {
                    statementInstance.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
                    error = CodeError.STATEMENT_CLOSE_FAIL;
                }
            }
        }
        return error;
    }

    public static int loadAllUser(ArrayList<User> listUser) {
        int error = CodeError.SUCESS;
        Connection connectionInstance = null;
        PreparedStatement statementInstance = null;
        String request = "SELECT userId, loginMail, password, administrator FROM user;";

        try {
            connectionInstance = MySQLConnect.getConnection();
            if (connectionInstance == null) {
                Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, "CONNEXION_FAIL");
                error = CodeError.CONNEXION_FAIL;
            } else {
                statementInstance = connectionInstance.prepareStatement(request);

                ResultSet result = statementInstance.executeQuery();

                while (result.next()) {
                    listUser.add(new User(result.getInt(1), result.getString(2), result.getString(3), result.getBoolean(4)));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
            error = CodeError.STATEMENT_EXECUTE_FAIL;
        } finally {
            if (statementInstance != null) {
                try {
                    statementInstance.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLUser.class.getName()).log(Level.SEVERE, null, ex);
                    error = CodeError.STATEMENT_CLOSE_FAIL;
                }
            }
        }
        return error;
    }

}
