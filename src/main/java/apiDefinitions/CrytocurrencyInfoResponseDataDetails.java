package apiDefinitions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CrytocurrencyInfoResponseDataDetails {

	private int id;
	private String name;
	private String symbol;
	private String slug;
	private String platform;
	private String category;
	private String description;
	private String logo;
	private String subreddit;
	private String notice;
	private List<String> tags;
	private List<String> tagNames;
	private List<String> tagGroups;
	private String date_added;
	private String twitter_username;
	private int is_hidden;
	private CrytocurrencyInfoResponseDataURLsDetails urls;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSubreddit() {
		return subreddit;
	}

	public void setSubreddit(String subreddit) {
		this.subreddit = subreddit;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getTagNames() {
		return tagNames;
	}

	public void setTagNames(List<String> tagNames) {
		this.tagNames = tagNames;
	}

	public List<String> getTagGroups() {
		return tagGroups;
	}

	public void setTagGroups(List<String> tagGroups) {
		this.tagGroups = tagGroups;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public String getTwitter_username() {
		return twitter_username;
	}

	public void setTwitter_username(String twitter_username) {
		this.twitter_username = twitter_username;
	}

	public int getIs_hidden() {
		return is_hidden;
	}

	public void setIs_hidden(int is_hidden) {
		this.is_hidden = is_hidden;
	}

	public CrytocurrencyInfoResponseDataURLsDetails getUrls() {
		return urls;
	}

	public void setUrls(CrytocurrencyInfoResponseDataURLsDetails urls) {
		this.urls = urls;
	}

}
