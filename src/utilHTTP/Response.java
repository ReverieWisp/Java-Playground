package utilHTTP;

/**
 * This structure represents a request from a given URL.
 * @author Wisp
 */
public class Response 
{
    // Default constructor, which by default creates an invalid response.
    public Response() 
    {
        this.content_ = ""; 
        this.valid_ = false;
    } 

    // General Constructor and the closest we can get to a conversion 
    // constructor in Java. Responses generated with this are valid, and CAN
    // be empty string.
    public Response(String message)
    {
        this.content_ = message;
        this.valid_ = true;
    }
    
    // Public member functions
    public boolean isValid()           { return valid_; }
    public void setContent(String msg) { this.content_ = msg; this.valid_ = true; }
    public String getContent()         { return this.content_; };

    // Variables
    private String content_;
    private boolean valid_;
}
