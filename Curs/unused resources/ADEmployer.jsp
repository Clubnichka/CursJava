﻿@model List<Employer>
@{
    ViewData["Title"] = "Работодатели";
}


<h1>Работодатели</h1>

<table border="1" cellspacing="10">
    <tr><th>Имя</th><th>опыт</th><th>Имя компании</th><th>Описание</th><th>Почта</th></tr>
    @foreach (var item in Model)
    {
        <tr>
            <td>@item.Name</td>
            <td>@item.companyName</td>
            <td>@item.Description</td>
            <td>@item.Email</td>
            <td>
                <form method="post" asp-controller="Home" asp-action="ADdropE2">
                    <p><button type="submit">Удалить работодателя</button></p>
                    <input type="hidden" name="e2ID" value="@item.Id" />
                </form>
            </td>
        </tr>

    }
</table>
<form method="post" asp-controller="Home" asp-action="ADaddE2">
    <p><button type="submit">Добавить работодателя</button></p>
</form>
<form method="post" asp-controller="Home" asp-action="HomeAdmin">
    <p><button type="submit">Назад</button></p>
</form>