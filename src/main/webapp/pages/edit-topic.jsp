<jsp:include page="/components/header.jsp"/>

<h2>
  Edit Topic
</h2>
  <form method="post" action="topic">
    <input type="text" value="edit" name="action">
    <label>ID</label>
    <input type="number" value="${topic.id}" name="id" readonly><br>
    <label>Topic Name</label>
    <input type="text" value="${topic.name}" name="name"><br>
    <button>Edit</button>
  </form>

<jsp:include page="/components/footer.jsp"/>