
package longParameterFix;

public class WalletNotification {
    private EmailService emailService;
    
    public WalletNotification(EmailService emailService){
        this.emailService = emailService;
    }
    
    public void balanceNotif(User user, int amount){
        if(amount == 0){
            throw new IllegalArgumentException("Tidak ada perubahan saldo");
        }
        
        String body = "";
        
        if(amount > 0){
            body = String.format(
                    "Halo %s, ada %.2f masuk ke akunmu" +
                    "Sekarang balance-mu menjadi %.2f", user.getName(), amount, user.getWallet().getBalance());
        } else if(amount < 0){
            body = String.format(
                    "Halo %s, ada %.2f keluar dari akunmu" +
                    "Sekarang balance-mu menjadi %.2f", user.getName(), amount, user.getWallet().getBalance());
        }
        
        this.emailService.send(user.getEmail(), body);
    }
}
