$(document).ready(function () {
  $('[required="required"]')
    .prev("label")
    .append("<span>*</span>")
    .children("span")
    .addClass("required");

  $("tbody tr:even").addClass("even");

  $("#btnAddTask").click(function (evt) {
    evt.preventDefault();
    $("#taskCreation").removeClass("not");
  });

  $("tbody").on("click", "tr", function (evt) {
    $(evt.target)
      .closest("td")
      .siblings()
      .andSelf()
      .toggleClass("rowHighlight");
  });

  $("#tblTasks tbody").on("click", ".deleteRow", function (evt) {
    evt.preventDefault();
    $(evt.target).closest("tr").remove();
    updateTaskCount();
  });

  $("#tblTasks tbody").on("click", ".editRow", function (evt) {
    evt.preventDefault();
    var $row = $(this).closest("tr");
    var index = $row.index();
    var task = {
      task: $row.find("td:eq(0)").text(),
      requiredBy: $row.find("td:eq(1) time").attr("datetime"),
      category: $row.find("td:eq(2)").text(),
      editIndex: index,
    };
    $("#taskForm").fromObject(task);
    $("#taskCreation").removeClass("not");
  });

  $("#tblTasks tbody").on("click", ".completeRow", function (evt) {
    evt.preventDefault();
    $(this).closest("tr").find("td").addClass("completed");
  });

  $("#saveTask").click(function (evt) {
    evt.preventDefault();
    var task = $("#taskForm").toObject();
    var editIndex = $("#editIndex").val();
    if (editIndex !== "") {
      $("#tblTasks tbody tr")
        .eq(editIndex)
        .replaceWith($("#taskRow").tmpl(task));
    } else {
      $("#taskRow").tmpl(task).appendTo($("#tblTasks tbody"));
    }
    $("#taskCreation").addClass("not");
    $("#taskForm")[0].reset();
    $("#editIndex").val("");
    updateTaskCount();
  });

  $("#clearTask").click(function (evt) {
    evt.preventDefault();
    $("#taskForm")[0].reset();
    $("#editIndex").val("");
  });

  $("#printTask").click(function (evt) {
    evt.preventDefault();
    var task = $("#taskForm").toObject();
    console.log(JSON.stringify(task, null, 2));
  });

  $("#loadTask").click(function (evt) {
    evt.preventDefault();
    var demoTask = {
      task: "Sample Task",
      requiredBy: "2024-12-31",
      category: "Personal",
    };
    $("#taskForm").fromObject(demoTask);
  });

  function updateTaskCount() {
    var count = $("#tblTasks tbody tr").length;
    $("#taskCount").text(count);
  }
});

(function ($) {
  $.fn.extend({
    toObject: function () {
      return this.serializeArray().reduce(function (result, field) {
        result[field.name] = field.value;
        return result;
      }, {});
    },
    fromObject: function (obj) {
      $.each(this.find(":input"), function (i, v) {
        var name = $(v).attr("name");
        if (obj[name]) {
          $(v).val(obj[name]);
        } else {
          $(v).val("");
        }
      });
    },
  });
})(jQuery);
