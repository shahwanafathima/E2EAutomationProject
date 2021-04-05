package apiDefinitions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CrytocurrencyInfoResponseDataURLsDetails {

	public List<String> technical_doc;
	public List<String> website;
	public List<String> twitter;
	public List<String> message_board;
	public List<String> chat;
	public List<String> explorer;
	public List<String> reddit;
	public List<String> source_code;
	public List<String> announcement;

	public List<String> getTechnical_doc() {
		return technical_doc;
	}

	public void setTechnical_doc(List<String> technical_doc) {
		this.technical_doc = technical_doc;
	}

	public List<String> getWebsite() {
		return website;
	}

	public void setWebsite(List<String> website) {
		this.website = website;
	}

	public List<String> getTwitter() {
		return twitter;
	}

	public void setTwitter(List<String> twitter) {
		this.twitter = twitter;
	}

	public List<String> getMessage_board() {
		return message_board;
	}

	public void setMessage_board(List<String> message_board) {
		this.message_board = message_board;
	}

	public List<String> getChat() {
		return chat;
	}

	public void setChat(List<String> chat) {
		this.chat = chat;
	}

	public List<String> getExplorer() {
		return explorer;
	}

	public void setExplorer(List<String> explorer) {
		this.explorer = explorer;
	}

	public List<String> getReddit() {
		return reddit;
	}

	public void setReddit(List<String> reddit) {
		this.reddit = reddit;
	}

	public List<String> getSource_code() {
		return source_code;
	}

	public void setSource_code(List<String> source_code) {
		this.source_code = source_code;
	}

	public List<String> getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(List<String> announcement) {
		this.announcement = announcement;
	}

}
