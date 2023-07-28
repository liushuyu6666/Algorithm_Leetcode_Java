import java.util.Stack;

public class Design_Browser_History {
    private Stack<String> backward;
    private Stack<String> forward;

    public Design_Browser_History(String homepage) {
        this.backward = new Stack<>();
        this.forward = new Stack<>();

        this.backward.push(homepage);
    }

    public void visit(String url) {
        this.backward.push(url);
        while(!this.forward.isEmpty()) {
            this.forward.pop();
        }
    }

    public String back(int steps) {

        while(this.backward.size() > 1 && steps > 0) {
            String prev = this.backward.pop();
            this.forward.push(prev);
            steps--;
        }

        return this.backward.peek();
    }

    public String forward(int steps) {
        while(this.forward.size() > 0 && steps > 0) {
            String next = this.forward.pop();
            this.backward.push(next);
            steps--;
        }

        return this.backward.peek();
    }
}
