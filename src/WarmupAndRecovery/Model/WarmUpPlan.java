package WarmupAndRecovery.Model;


    public class WarmUpPlan {
        private String clientId;
        private String planDetails;

        // Correct Constructor (No return type)
        public WarmUpPlan(String clientId, String planDetails) {
            this.clientId = clientId;
            this.planDetails = planDetails;
        }

        // Getter method (Return type is String)
        public String getClientId() {
            return clientId;
        }

        // Getter method (Return type is String)
        public String getPlanDetails() {
            return planDetails;
        }

        // Setter method (Return type is void)
        public void setPlanDetails(String planDetails) {
            this.planDetails = planDetails;
        }
}
