/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ContractInfoDialog.java
 *
 * Created on Jan 13, 2010, 2:54:20 PM
 */
package ptscontractinfos;

//import com.ib.client.Contract;

import com.ib.client.Contract;
import javax.swing.JFrame;

//import javax.swing.JFrame;
//import petrasys.connections.ContractInfos;

/**
 *
 * @author rickcharon
 */
public class ContractInfoDialog extends javax.swing.JDialog {
  private ContractInfos contractInfos;

  /** Creates new form ContractInfoDialog */
  public ContractInfoDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    contractInfos = new ContractInfos();
  }

  public ContractInfoDialog(JFrame parent)  {
    super(parent, true);
    initComponents();
    contractInfos = new ContractInfos();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    symbolInTextBox = new javax.swing.JTextField();
    exchangeTextBox = new javax.swing.JTextField();
    CancelButton = new javax.swing.JButton();
    goButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Get All Contract Expirations and Details for Futures");
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowOpened(java.awt.event.WindowEvent evt) {
        formWindowOpened(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
    jLabel1.setText("BaseSymbol:");

    jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
    jLabel2.setText("Exchange:");

    symbolInTextBox.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
    symbolInTextBox.setText("ZB");

    exchangeTextBox.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
    exchangeTextBox.setText("ECBOT");

    CancelButton.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
    CancelButton.setText("Cancel");
    CancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        CancelButtonActionPerformed(evt);
      }
    });

    goButton.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
    goButton.setText("GO");
    goButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        goButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addGroup(layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CancelButton))
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(symbolInTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(39, 39, 39)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(exchangeTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(goButton))
        .addContainerGap(222, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(22, 22, 22)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(symbolInTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(exchangeTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(CancelButton)
          .addComponent(goButton))
        .addGap(47, 47, 47))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
      setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
      Contract contract = new Contract();
      contract.m_symbol = symbolInTextBox.getText().toUpperCase();
      contract.m_secType = "FUT";
      contract.m_exchange = exchangeTextBox.getText().toUpperCase();
      contract.m_includeExpired = true;
      contractInfos.setParams(this, contract);
      Thread ciThread = new Thread(contractInfos);
      ciThread.run();
      //Trader trader = Dispatcher.getTrader();
      //trader.setContractDetailsConnection(this);
      //Strategy strategy = new DownloaderStrategy(); // a dummy strategy, needed for the framework
      //trader.getAssistant().addStrategy(strategy); //Updates id for TWS
      //int requestId = strategy.getId();
      //trader.getAssistant().requestContractDetails(requestId, contract);
    }//GEN-LAST:event_goButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        ContractInfoDialog dialog = new ContractInfoDialog(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {

          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton CancelButton;
  private javax.swing.JTextField exchangeTextBox;
  private javax.swing.JButton goButton;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JTextField symbolInTextBox;
  // End of variables declaration//GEN-END:variables
}
