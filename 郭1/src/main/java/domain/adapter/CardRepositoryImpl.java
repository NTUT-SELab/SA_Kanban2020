package domain.adapter;

import domain.entity.Card;
import domain.entity.Task;
import domain.usecase.card.CardRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class CardRepositoryImpl implements CardRepository {
    private HashMap<String, Card> _cardRepository ;
    private Connection conn;

    public CardRepositoryImpl(){
        _cardRepository = new HashMap<String, Card>() ;
    }

    public Card get(String id){
        return this._cardRepository.get(id) ;
    }

    public void save(Card newCard){
        try {
            this._cardRepository.put(newCard.getId(), newCard) ;
            this.conn = DatabaseImpl.getConnection();
            add(newCard.getId(), newCard.getName());
            conn.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }



    public void add(String cardId, String cardName){
        //save card
        String sql = "INSERT INTO kanban.card(id, name) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cardId);
            ps.setString(2,cardName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("???????"+_cardRepository.get(cardId).getTaskMap().values().size());

        PreparedStatement ps1 = null;
        sql = "INSERT INTO kanban.subtask(id, name) VALUES (?,?)";
        try {
            System.out.println(_cardRepository.get(cardId).getTaskMap().values().size());
            for(Task task : _cardRepository.get(cardId).getTaskMap().values() ){
                System.out.println(task.getName() + task.getId());
                ps1 = conn.prepareStatement(sql);
                ps1.setString(1,task.getId());
                ps1.setString(2,task.getName());
                ps1.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps1 != null) {
                try {
                    ps1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
