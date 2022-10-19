
package longParameter;

public class WalletNotification {
    private EmailService emailService;
    
    public WalletNotification(EmailService emailService){
        this.emailService = emailService;
    }
    
    public void balanceNotif(String name, String email, int amount, int current){
        if(amount == 0){
            throw new IllegalArgumentException("Tidak ada perubahan saldo");
        }
        
        String body = "";
        
        if(amount > 0){
            body = String.format(
                    "Halo %s, ada %.2f masuk ke akunmu" +
                    "Sekarang balance-mu menjadi %.2f", name, amount, current);
        } else if(amount < 0){
            body = String.format(
                    "Halo %s, ada %.2f keluar dari akunmu" +
                    "Sekarang balance-mu menjadi %.2f", name, amount, current);
        }
        
        this.emailService.send(email, body);
    }
}
